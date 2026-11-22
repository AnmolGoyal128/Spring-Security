package in.springBoot.SpringPracticalDemo.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

    private boolean isEnabled = true;


}
