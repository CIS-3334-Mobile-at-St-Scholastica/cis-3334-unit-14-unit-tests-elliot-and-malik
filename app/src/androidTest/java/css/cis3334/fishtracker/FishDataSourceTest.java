package css.cis3334.fishtracker;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FishDataSourceTest {

    @Test
    public void deleteFish() {
        // Arrange - set up a fish database with one fish in it
        Context appContext = InstrumentationRegistry.getTargetContext();         // Context of the app under test.
        FishDataSource fishDataSource = new FishDataSource(appContext);          // set up the fish data source
        fishDataSource.open();                                                   // open up this data source--close before we leave
        List<Fish> origFistList =  fishDataSource.getAllFish();                  // count number of fish
        Fish fish = fishDataSource.createFish("Walleye", "1 lb, 3 oz", "April 12");         // create a fish

        // Act - delete the fish we added
        fishDataSource.deleteFish(fish);

        // Assert - check the number of fish before and after match
        List<Fish> modFistList =  fishDataSource.getAllFish();
        assertEquals(origFistList.size(),modFistList.size() );
    }


    @Test
    public void getAllFish() {
        // Arrange - set up a fish database with one fish in it
        Context appContext = InstrumentationRegistry.getTargetContext();         // Context of the app under test.
        FishDataSource fishDataSource = new FishDataSource(appContext);          // set up the fish data source
        fishDataSource.open();                                                   // open up this data source--close before we leave
        List<Fish> origFistList =  fishDataSource.getAllFish();                  // count number of fish
        Fish fish = fishDataSource.createFish("Walleye", "1 lb, 3 oz", "April 12");
        Fish fish2 = fishDataSource.createFish("Walleye", "1 lb, 3 oz", "April 13");
        Fish fish3 = fishDataSource.createFish("Walleye", "1 lb, 3 oz", "April 14");

        //Act - gets all fish that we added to the application
        List<Fish> allFish =  fishDataSource.getAllFish();

        // Assert - check the number of fish within the Firebase
        assertEquals(allFish.size(), origFistList.size() + 3);
    }
}