package ca.humber.group2.cpan228finalproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Event name is required.")
    private String name;

    @NotNull(message = "Event type is required.")
    @Enumerated(EnumType.STRING)
    private EventType type;

    @NotBlank(message = "Location is required.")
    private String location;

    @NotNull(message = "Event date is required.")
    @FutureOrPresent(message = "Event date must be today or in the future.")
    private LocalDate eventDate;

    @NotNull(message = "Capacity is required.")
    @Min(value = 1, message = "Capacity must be at least 1.")
    @Max(value = 500, message = "Capacity must be 500 or less.")
    private Integer capacity;

    @NotNull(message = "Price is required.")
    @DecimalMin(value = "0.00", message = "Price cannot be negative.")
    @DecimalMax(value = "500.00", message = "Price must be 500 or less.")
    private BigDecimal price;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Event() {}

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public EventType getType() { return type; }
    public String getLocation() { return location; }
    public LocalDate getEventDate() { return eventDate; }
    public Integer getCapacity() { return capacity; }
    public BigDecimal getPrice() { return price; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setType(EventType type) { this.type = type; }
    public void setLocation(String location) { this.location = location; }
    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}