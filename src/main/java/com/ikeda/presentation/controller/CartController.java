package com.ikeda.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ikeda.entity.DvdItem;
import com.ikeda.repository.DvdItemRepository;
import com.ikeda.service.CartService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private DvdItemRepository itemRepository;

    // カート追加
    @SuppressWarnings("unchecked")
	@GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") int id, HttpSession session) {

        DvdItem item = itemRepository.findById(id).orElse(null);

        if (item != null) {
            cartService.addToCart(item, session);
        }

        return "redirect:/cart"; // カート画面へ
    }

    // カート表示
    @GetMapping
    public String showCart(Model model, HttpSession session) {
        model.addAttribute("cart", cartService.getCart(session));
        return "cart";  // cart.html を表示
    }

    // カートの商品削除
    @GetMapping("/delete/{id}")
    public String deleteCartItem(@PathVariable("id") int id, HttpSession session) {
        cartService.removeFromCart(id, session);
        return "redirect:/cart";
    }

    // カート内商品を全て削除
    @GetMapping("/clear")
    public String clearCart(HttpSession session) {
        cartService.clearCart(session);
        return "redirect:/cart";
    }
}
