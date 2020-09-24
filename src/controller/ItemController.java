/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.custom.impl.ItemDAOImpl;
import dao.CrudDAO;
import dao.DAOFactory;
import dao.SuperDAO;
import dao.custom.ItemDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import dto.ItemDTO;
import entity.Item;

/**
 *
 * @author sanu-vithanage
 */
public class ItemController {

    static ItemDAO dao = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);

    public static boolean addItem(ItemDTO dto) throws ClassNotFoundException, SQLException, Exception {
        return dao.add(new Item(dto.getCode(), dto.getDescription(), dto.getQty(), dto.getUnitPrice()));
    }

    public static boolean deleteItem(String code) throws ClassNotFoundException, SQLException, Exception {
        return dao.delete(code);
    }

    public static boolean updateItem(ItemDTO dto) throws ClassNotFoundException, SQLException, Exception {
        return dao.update(new Item(dto.getCode(), dto.getDescription(), dto.getQty(), dto.getUnitPrice()));
    }

    public static ItemDTO searchItem(String code) throws ClassNotFoundException, SQLException, Exception {
        Item enty = dao.search(code);
        return new ItemDTO(enty.getCode(), enty.getDescription(), enty.getQtyOnHand(), enty.getUnitPrice());
    }

    public static ArrayList<ItemDTO> getAllItems() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Item> all = dao.getAll();
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        for (Item enty : all) {
            allItems.add(new ItemDTO(enty.getCode(), enty.getDescription(), enty.getQtyOnHand(), enty.getUnitPrice()));
        }
        return allItems;
    }

}
