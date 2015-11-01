package util;

import java.util.ArrayList;

public interface IRepository<T> {
    ArrayList<T> findAll();
}
