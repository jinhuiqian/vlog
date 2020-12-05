package com.jinhuiqian.vlog.controller;

import com.jinhuiqian.vlog.common.ResponseResult;
import com.jinhuiqian.vlog.common.ResultCode;
import com.jinhuiqian.vlog.model.Card;
import com.jinhuiqian.vlog.utils.DataUtil;
import org.springframework.beans.propertyeditors.ClassArrayEditor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 231
 * @date 2020-12-03 14:33
 */
@RestController
@RequestMapping(value = "api")
public class CardController {

    @GetMapping("cards")
    public ResponseResult getCards(){
        List<Card> cards = DataUtil.initCards();
        ResultCode success = ResultCode.SUCCESS;
        return ResponseResult.success(cards);
    }
}
