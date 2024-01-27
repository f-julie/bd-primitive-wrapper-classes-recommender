package com.amazon.ata.debugging.subscribeandsave;

import com.amazon.ata.debugging.subscribeandsave.dao.SubscriptionDAO;
import com.amazon.ata.debugging.subscribeandsave.dao.SubscriptionFileStorage;
import com.amazon.ata.debugging.subscribeandsave.service.SubscriptionService;
import com.amazon.ata.resources.debugging.classroom.dependencies.AmazonIdentityService;
import com.amazon.ata.resources.debugging.classroom.dependencies.AmazonProductService;

import java.io.File;

/**
 * Provides inversion of control for the SNS MLP by instantiating all of the
 * dependencies needed by the SubscriptionDebugUtil and its dependency classes.
 */
public class App {
    private static final String RESOURCES_BASE_PATH = "resources/debugging/classroom/subscribeandsave/";

    private App() {
    }

    /**
     * Gets amazon product service.
     *
     * @return the amazon product service
     */
    public static AmazonProductService getAmazonProductService() {
        return new AmazonProductService(
            new File(RESOURCES_BASE_PATH + "catalog.json"));
    }

    /**
     * Gets amazon identity service.
     *
     * @return the amazon identity service
     */
    public static AmazonIdentityService getAmazonIdentityService() {
        return new AmazonIdentityService(
            new File(RESOURCES_BASE_PATH + "customers.txt"));
    }

    /**
     * Gets subscription dao.
     *
     * @return the subscription dao
     */
    public static SubscriptionDAO getSubscriptionDAO() {
        return new SubscriptionDAO(getSubscriptionFileStorage());
    }

    /**
     * Gets subscription file storage.
     *
     * @return the subscription file storage
     */
    public static SubscriptionFileStorage getSubscriptionFileStorage() {
        return new SubscriptionFileStorage(
            new File(RESOURCES_BASE_PATH + "subscriptions.csv"));
    }

    /**
     * Gets subscription service.
     *
     * @return the subscription service
     */
    public static SubscriptionService getSubscriptionService() {
        return new SubscriptionService(getAmazonIdentityService(), getSubscriptionDAO(), getAmazonProductService());
    }

}
