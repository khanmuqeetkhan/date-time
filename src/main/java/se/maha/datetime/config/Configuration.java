package se.maha.datetime.config;

import java.time.Clock;

//@Configuration
public class Configuration {

    //@Bean
    public Clock clock() {
        return Clock.systemUTC();
    }
}
