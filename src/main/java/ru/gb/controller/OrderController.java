package ru.gb.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.gb.domain.Order;
import ru.gb.service.OrderService;

@Slf4j
@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @PostMapping("add")
  public void save(@RequestBody Order order) {
    orderService.save(order);
  }

  @GetMapping
  @ResponseBody
  public List<Order> getAll() {
    return orderService.geAll();
  }
}
