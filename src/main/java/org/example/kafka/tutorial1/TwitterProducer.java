package org.example.kafka.tutorial1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TwitterProducer {
    public static void main(String[] args) {
        new TwitterProducer().run();
    }

    void run(){
//                create a twitter client

//                create a kafka producer
//                loop to send tweets to kafka
    }

    public void createTwitterClient(){
        /** Set up your blocking queues: Be sure to size these properly based on expected TPS of your stream */
        BlockingQueue<String> msgQueue = new LinkedBlockingQueue<String>(100000);
//        BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<Event>(1000);
        /** Declare the host you want to connect to, the endpoint, and authentication (basic auth or oauth) */
//        Hosts hosebirdHosts = new HttpHosts(Constants.STREAM_HOST);
//        StatusesFilterEndpoint hosebirdEndpoint = new StatusesFilterEndpoint();
// Optional: set up some followings and track terms
//        List<Long> followings = Lists.newArrayList(1234L, 566788L);
//        List<String> terms = Lists.newArrayList("twitter", "api");
//        hosebirdEndpoint.followings(followings);
//        hosebirdEndpoint.trackTerms(terms);

// These secrets should be read from a config file
//        Authentication hosebirdAuth = new OAuth1("consumerKey", "consumerSecret", "token", "secret");
    }
}
