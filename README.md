## Prime Video Recommender

### Intro

We want to create a new Kid's Alexa Skill to
recommend movies. Since kids' taste change so often - today Sesame Street is in,
tomorrow it's Paw Patrol - we want to base our recommendations on only the last
10 movies watched through Prime Video. Let's start off by taking a look at the
`PrimeVideo` class in the `src/com/amazon/ata/generics/recommender/movie`
directory. There are two fields that have the datatype `long` present in this
class, one a primitive and one a primitive Wrapper class. Why do you think the
decision was made for each of these types?

### Defining the generic types
We want to use a combination of the provided `MostRecentlyUsed` and
`ReadOnlyDAO` to build our `PrimeVideoRecommender` class. Let's learn more about
these existing classes from the class diagram `PrimeVideoRecommender.puml` in
`src/com/amazon/ata/generics/recommender` and their JavaDocs in
`Javadocs`. Discuss with your group how you think the `PrimeVideoRecommender`
will use these classes.

What types will you want to use for the generics in `PrimeVideoRecommender`?
From the UML diagram we see three generic types, `E`, `K`, and `V`. With your
group, decide which types you will want to use for `E` in `MostRecentlyUsed`
and for `K` and `V` in `ReadOnlyDAO`. Once you've come to a consensus, continue
with the implementation.

## Implementation

### Update the generic types in the `PrimeVideoRecommender` and the test classes
Let's go ahead and define those generic types in our `PrimeVideoRecommender`
member variables and constructor. Replace any question marks in `PrimeVideoRecommender`
with the classes you've decided upon. You will also need to update 
`PrimeVideoRecommenderGetRecommendationTest` and `PrimeVideoRecommenderWatchTest`.

Goal:
* All `?`s in `PrimeVideoRecommender`, `PrimeVideoRecommenderGetRecommendationTest`,
  and `PrimeVideoRecommenderWatchTest` are replaced with the classes you
  decided on in the previous step.
* The classes compile and we don't see anything underlined in red in IntelliJ.

### Implement `watch`
Implement the `watch` method. We want to track the movie that was just watched
in our `MostRecentlyUsed` collection. Let's say our `MostRecentlyUsed` is
configured with a capacity of 10 items. If there were already 8 items in our
`MostRecentlyUsed` collection, how many will there be after calling the `watch`
method? What's changed? What if there were already 10 items before we called
`watch`?

You'll also need to complete the implementation of this test in the
`PrimeVideoRecommenderWatchTest` class:
* `watch_watchPrimeVideo_addToMostRecentlyViewed`

Either run the unit tests in `PrimeVideoRecommenderWatchTest` in IntelliJ or run
the `./gradlew -q clean :test --tests com.amazon.ata.generics.recommender.movie.PrimeVideoRecommenderWatchTest` gradle command to make sure that the unit tests for watch
are now passing.

Goal:
* `PrimeVideoRecommenderWatchTest` unit tests are passing.

## COMPLETION: Implement `getRecommendation`
Implement the `getRecommendation` method so that it pulls a random movie from
one of the most recently viewed movies. It should return that movie's most
similar movie as our recommendation.

You'll also need to complete the implementation of this test in the
`PrimeVideoRecommenderGetRecommendationTest` class:
* `getRecommendation_singleVideoWatched_returnsRecommendation`

Either run the unit tests in `PrimeVideoRecommenderGetRecommendationTest` in 
IntelliJ or run the `./gradlew -q clean :test --tests com.amazon.ata.generics.recommender.movie.PrimeVideoRecommenderGetRecommendationTest` gradle command to make sure that the
unit tests for watch are now passing.

Goal:
* `PrimeVideoRecommenderGetRecommendationTest` unit tests succeed.

## Extensions
### Enhance `getRecommendation`
In the case that our first random selection does not have a similar
video, we'd like to continue trying. Enhance your recommendation
algorithm to find a recommendation using the rest of the most recently
viewed videos. If none of the viewed videos have recommendations, return
null. This change will likely cause existing unit tests to fail. You 
will need to decide if the tests are no longer valid based on the new
behavior you have implemented. You should also be writing new tests to 
confirm the enhancements.

### Recommend all the things!
The kids product team heard of our awesome new Alexa skill and want to start
recommending products to kids as well. They've sent us their `Product` class you
can see in the `src/com/amazon/ata/generics/recommender/product`
directory. They asked us to make them a `ProductRecommender` with `purchase` and
`getRecommendation` methods. But we thought we can do them one better, make a
more flexible `Recommender` class that could be used for either movies or
products.

Take a look at the `PrimeVideo` class and the `Product` class. What do they have in
common? Create a class diagram with a suggestion on the classes and
relationships you need to implement a more flexible `Recommender` class. Compare
designs with your teammates. Once you come to a consensus, start coding!

## Commit & Push

1. When you have the code to where you want it (at least compiling, ideally all
   tests passing), commit it.
1. Push it to your remote branch.
3. Go back to the Recommender Canvas page and paste in a link to your commit.
