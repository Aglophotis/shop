package ru.mirea.data;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StuffController {

    @Autowired
    private StuffService stuffService;

    @RequestMapping(value = "/stuff", method = RequestMethod.GET)
    @ResponseBody
    public ObjectNode stuffs(){
        return stuffService.getStuffs();
    }

    @RequestMapping(value = "/cart/currency/balance", method = RequestMethod.POST)
    @ResponseBody
    public String pay() {
        return stuffService.paymentOfCart();
    }

}
