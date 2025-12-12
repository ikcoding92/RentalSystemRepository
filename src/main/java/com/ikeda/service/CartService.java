package com.ikeda.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ikeda.entity.DvdItem;

import jakarta.servlet.http.HttpSession;

@Service
public class CartService {

    private static final String SESSION_CART_KEY = "cart";

    // 現在のカートを取得
    public List<DvdItem> getCart(HttpSession session) {
        List<DvdItem> cart = (List<DvdItem>) session.getAttribute(SESSION_CART_KEY);
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute(SESSION_CART_KEY, cart);
        }
        return cart;
    }

    // カートに商品を追加
    public void addToCart(DvdItem item, HttpSession session) {
        List<DvdItem> cart = getCart(session);
        cart.add(item);
        session.setAttribute(SESSION_CART_KEY, cart); // 更新を保存
    }

    // 指定IDの商品をカートから削除
    public void removeFromCart(int id, HttpSession session) {
        List<DvdItem> cart = getCart(session);
        cart.removeIf(i -> i.getId() == id);
        session.setAttribute(SESSION_CART_KEY, cart);
    }

    // カートを空にする
    public void clearCart(HttpSession session) {
        session.setAttribute(SESSION_CART_KEY, new ArrayList<>());
    }
}
