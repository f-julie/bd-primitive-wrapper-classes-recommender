package com.amazon.ata.generics.recommender.movie;

import com.amazon.ata.generics.recommender.MostRecentlyUsed;
import com.amazon.ata.generics.recommender.ReadOnlyDao;

import java.util.Random;

/**
 * Recommends a movie based on the most recently viewed movies in Prime Video.
 * <p>
 * PARTICIPANTS: Replace the placeholders in the generics used in the class members and constructor with their proper
 * types.
 */
public class PrimeVideoRecommender {
    // PARTICIPANT -- Update the generic types in PrimeVideoRecommender
    private MostRecentlyUsed<?> mostRecentlyViewed;
    private ReadOnlyDao<?, ?> primeVideoDao;
    private Random random;

    /**
     * Instantiates a new Prime video recommender.
     *
     * @param mostRecentlyViewed the most recently viewed
     * @param primeVideoDao      the prime video dao
     * @param random             the random
     */
    // PARTICIPANT -- Update the generic types in PrimeVideoRecommender
    public PrimeVideoRecommender(MostRecentlyUsed<?> mostRecentlyViewed,
                                 ReadOnlyDao<?, ?> primeVideoDao, Random random) {
        this.mostRecentlyViewed = mostRecentlyViewed;
        this.primeVideoDao = primeVideoDao;
        this.random = random;
    }


    /**
     * Add a newly watched video to the mostRecentlyViewed. If the video doesn't exist throw an
     * IllegalArgumentException.
     *
     * @param videoId ID of the video that was watched on Prime Video
     */
    public void watch(long videoId) {
        // PARTICIPANT -- Implement watch()
    }

    /**
     * Selects a random video from the mostRecentlyViewed videos, and that video's most similar PrimeVideo
     * is returned as the recommendation. If the randomly selected video does not have a most similar
     * PrimeVideo, return null. If there are not most recently viewed movies, null will be returned.
     * <p>
     * EXTENSION
     * In the case that our first random selection does not have a similar video, we'd like to continue trying. Enhance
     * your recommendation algorithm to find a recommendation using the rest of the most recently viewed videos.
     * If none of the viewed videos have recommendations, return null.
     *
     * @return PrimeVideo to recommend watching.
     */
    public PrimeVideo getRecommendation() {
        // PARTICIPANT -- Implement getRecommendation()
        return null;
    }
}
