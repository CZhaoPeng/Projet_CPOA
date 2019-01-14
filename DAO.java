package dao;

import java.util.ArrayList;

public interface DAO<T> {
	public abstract T getById(int id);
	public abstract void create(T objet);
	public abstract void update(T objet);
	//public abstract void delete(int id);
	public abstract void delete(T objet);
	//public abstract void afficherT();
	public abstract ArrayList<T> findAll();
}
