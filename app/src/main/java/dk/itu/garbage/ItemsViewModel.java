package dk.itu.garbage;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemsViewModel extends ViewModel {
    // only used by this class, only one can exist (belongs to the class)
    private static MutableLiveData<ItemsDB> items;

   public ItemsViewModel() {
       // items initialized at instantiation
       items = new MutableLiveData<>();
       // and value set (using the public constructor)
       items.setValue(new ItemsDB());
   }

   public MutableLiveData<ItemsDB> getValue() {
       return items;
   }

    /** assigns the values of items to a the ItemsDB (temp),
     * adds the input item to temp, and assigns items to contain newly input and all prev items from ItemDB */
   public void addItem(String what, String where) {
       ItemsDB temp = items.getValue();
       temp.addItem(what, where);
       items.setValue(temp);
   }

   public void removeItem(String what) {
       ItemsDB temp = items.getValue();
       temp.removeItem(what);
       items.setValue(temp);
   }

   //?
   public String searchItems(String what) {
       ItemsDB temp = items.getValue();
       return temp.searchItems(what);
   }
}
