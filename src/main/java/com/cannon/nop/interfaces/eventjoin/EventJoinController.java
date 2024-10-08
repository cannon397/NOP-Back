package com.cannon.nop.interfaces.eventjoin;



import com.cannon.nop.application.EventJoinService;
import com.cannon.nop.application.EventService;
import com.cannon.nop.domain.event.model.Event;

import com.cannon.nop.interfaces.config.ApiResponse;
import com.cannon.nop.interfaces.config.jsonview.Views;
import com.cannon.nop.interfaces.event.dto.response.EventResponse;
import com.cannon.nop.interfaces.event.mapstruct.EventMapper;
import com.cannon.nop.interfaces.eventjoin.dto.request.EventJoinRequest;
import com.cannon.nop.interfaces.eventjoin.mapstruct.EventJoinMapper;
import com.cannon.nop.interfaces.validator.ValidateUUID;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/event")
public class EventJoinController {

    private final EventJoinService eventJoinService;
    private final EventService eventService;
    private final EventMapper eventMapper;
    private final EventJoinMapper eventJoinMapper;

    @GetMapping("{eventUrlUUID}")
    @JsonView(Views.WhenEventJoin.class)
    public EventResponse getEventInformation(@PathVariable @ValidateUUID  String eventUrlUUID) {
        Event event = eventService.getEvent(eventUrlUUID);
        EventResponse eventResponse = eventMapper.toDto(event);
        return eventResponse;
    }
    @PostMapping("{eventUrlUUID}/join")
    public ResponseEntity<ApiResponse> joinEvent(@PathVariable @ValidateUUID  String eventUrlUUID, @Valid @RequestBody EventJoinRequest eventJoinRequest){
        eventJoinRequest.setEventUrlUUID(eventUrlUUID);
        eventJoinService.joinEvent(eventJoinMapper.toEntity(eventJoinRequest));
        return ResponseEntity.ok(new ApiResponse(true,"이벤트 참여에 성공했습니다."));
    }
}
