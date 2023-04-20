package application.car_owner.repository;

import java.util.Vector;

public interface CarListRepository {
    Vector<String>  getCol_name();
    Vector<Vector<String>> getData();
}