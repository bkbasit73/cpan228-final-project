package ca.humber.group2.cpan228finalproject.controller;

import ca.humber.group2.cpan228finalproject.model.Event;
import ca.humber.group2.cpan228finalproject.model.EventType;
import ca.humber.group2.cpan228finalproject.repository.EventRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // LIST + FILTER + SORT (same page /events)
    @GetMapping
    public String list(
            @RequestParam(required = false) EventType type,
            @RequestParam(defaultValue = "eventDate") String sort,
            @RequestParam(defaultValue = "asc") String dir,
            Model model
    ) {
        // allow only safe sort fields
        if (!sort.equals("eventDate") && !sort.equals("capacity") && !sort.equals("price")) {
            sort = "eventDate";
        }

        Sort.Direction direction = dir.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sortObj = Sort.by(direction, sort);

        List<Event> events = (type == null)
                ? eventRepository.findAll(sortObj)
                : eventRepository.findByType(type, sortObj);

        model.addAttribute("events", events);
        model.addAttribute("types", EventType.values());

        // keep dropdowns selected after Apply
        model.addAttribute("selectedType", type);
        model.addAttribute("selectedSort", sort);
        model.addAttribute("selectedDir", dir);

        return "events/list";
    }

    // SHOW CREATE FORM
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("types", EventType.values());
        return "events/new";
    }

    // SAVE EVENT
    @PostMapping
    public String create(@Valid @ModelAttribute("event") Event event,
                         BindingResult bindingResult,
                         Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("types", EventType.values());
            return "events/new";
        }

        eventRepository.save(event);
        return "redirect:/events";
    }
}