/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOFactory;
import dao.SuperDAO;
import dao.custom.OrderDAO;
import dao.custom.OrderDetailDAO;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import dto.OrderDetailDTO;
import dto.OrdersDTO;
import entity.OrderDetail;
import entity.Orders;

/**
 *
 * @author sanu-vithanage
 */
public class OrderController {

    static OrderDAO orderdao = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
    static OrderDetailDAO orderDetailDao = (OrderDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);

    public static boolean purchaseOrder(OrdersDTO orderDTO, ArrayList<OrderDetailDTO> orderDetails) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        boolean add = orderdao.add(new Orders(orderDTO.getId(), orderDTO.getDate(), orderDTO.getCustomerID()));
        if (add) {
            for (OrderDetailDTO o : orderDetails) {
                boolean add1 = orderDetailDao.add(new OrderDetail(o.getOrderId(), o.getItemCode(), o.getQty(), o.getUnitPrice()));
                if (!add1) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } else {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }
    }
}
