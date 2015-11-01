package util;

public interface IRepositoryMapper<T> {
    T map(DataEntry dataEntry);
}
