package com.action.hotel;

import com.model.Hotel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RoomService;

import java.util.Map;

/**
 * Created by stiles on 16/1/2.
 */
public class HotelRemoveRoomAction extends ActionSupport {
    RoomService roomService;

    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }

    String room_id;

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        //Hotel hotel = (Hotel)session.get("hotel");
        if (roomService.remove(room_id)) {
            session.put("message", "成功删除房间信息");
            return SUCCESS;
        } else {
            System.out.println("here");
            addFieldError("error", "此房间关联了订单,无法删除");
            return INPUT;
        }
    }
}
