package br.com.up.ruokAdmin.repository;

import java.util.ArrayList;

import br.com.up.ruokAdmin.model.Humor;

public class GiftRepository {

    private static GiftRepository repository;

    public static GiftRepository getInstance(){
        if(repository == null){
            repository = new GiftRepository();
        }
        return repository;
    }

    private ArrayList<Humor> gifts = new ArrayList<>();

    private GiftRepository(){ }

    public void save(Humor gift){
        gifts.add(gift);
    }

    public void delete(Humor gift){
        gifts.remove(gift);
    }

    public ArrayList<Humor> getAll(){
        return gifts;
    }

    public Humor getByIndex(int index){
        return gifts.get(index);
    }

    public void update(int index, Humor gift){
        gifts.set(index,gift);
    }
}
