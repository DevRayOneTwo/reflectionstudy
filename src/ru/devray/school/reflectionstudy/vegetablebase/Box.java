package ru.devray.school.reflectionstudy.vegetablebase;


import ru.devray.school.reflectionstudy.vegetablebase.stores.StoreBrand;

public class Box<GreenFood> {
    int storeId;
    StoreBrand storeName;
    GreenFood food;

    public Box(int storeId, StoreBrand storeName, GreenFood food) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.food = food;
    }

    public GreenFood getFood() {
        return food;
    }
}
