package jhu.rest.jpa;

public class Reviews {
    private Long id;
    private Long restaurant_id;
    private Long customer_id;
    private Long reservation_id;
    private Integer score;
    private String content;
    public Reviews(Long id, Long restaurant_id, Long customer_id, Long reservation_id, Integer score, String content) {
        this.id = id;
        this.restaurant_id = restaurant_id;
        this.customer_id = customer_id;
        this.reservation_id = reservation_id;
        this.score = score;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Long getRestaurantId() {
        return restaurant_id;
    }

    public void setRestaurantId(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public Long getCustomerId() {
        return customer_id;
    }

    public void setCustomerId(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Long reservation_id() {
        return reservation_id;
    }

    public void setReservationId(Long reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }
}