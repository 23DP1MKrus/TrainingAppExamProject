package com.example.traininapp.ChallengePack;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "challenges")
@Getter
@Setter
@ToString
public class Challenge {
    @Id
    @SequenceGenerator(
            name = "challenge_sequence",
            sequenceName = "challenge_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "challenge_sequence"
    )
    private Long id;
    private String title;
    private String content;
    private Boolean completed;

    public Challenge(Long id, String title, String content, Boolean completed) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.completed = completed;
    }

    public Challenge(Boolean completed, String content, String title) {
        this.completed = completed;
        this.content = content;
        this.title = title;
    }

    public Challenge() {

    }
}
