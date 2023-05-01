package com.example;

import java.util.Date;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class ReviewsController {
    private List<Reviews> myReviews = new ArrayList();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "/reviews")
    public ResponseEntity getReviews(@RequestParam(value ="restaurantId") Long restaurant_id) {
        Reviews itemToReturn = null;
        for (Reviews review : myReviews) {
            if (review.getRestaurantId() == restaurant_id)
                itemToReturn = review;
        }
        return ResponseEntity.ok(itemToReturn);
    }

    @PostMapping(value = "/addreview")
    public ResponseEntity addToPlaylist(@RequestParam(value ="restaurantId") Long restaurant_id,
                                        @RequestParam(value ="customerId") Long customer_id,
                                        @RequestParam(value ="reservationId") Long reservation_id,
                                        @RequestParam(value ="score") Integer score,
                                        @RequestParam(value ="content") String content) {
        myReviews.add(new Reviews(counter.incrementAndGet(), restaurant_id, customer_id, reservation_id, score, content));
        return ResponseEntity.ok(myReviews);
    }

    @PutMapping(value = "/updatecourse")
    public ResponseEntity updateCourse(@RequestParam(value ="id") Long id,
                                       @RequestParam(value ="restaurantId") Long restaurant_id,
                                       @RequestParam(value ="customerId") Long customer_id,
                                       @RequestParam(value ="reservationId") Long reservation_id,
                                       @RequestParam(value ="score") Integer score,
                                       @RequestParam(value ="content") String content) {
        myReviews.forEach(CourseList -> {
            if (CourseList.getId() == id) {
                CourseList.setRestaurantId(restaurant_id);
                CourseList.setCustomerId(customer_id);
                CourseList.setReservationId(reservation_id);
                CourseList.setScore(score);
                CourseList.setContent(content);
            }
        });
        return ResponseEntity.ok(myReviews);
    }

    @DeleteMapping(value = "/deletereview")
    public ResponseEntity removeReview(@RequestParam(value ="id") Long id) {
        Reviews itemToRemove = null;
        for (Reviews review : myReviews) {
            if (review.getId() == id)
                itemToRemove = review;
        }
        myReviews.remove(itemToRemove);
        return ResponseEntity.ok(myReviews);
    }
}