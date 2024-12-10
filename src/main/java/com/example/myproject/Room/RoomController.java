package com.example.myproject.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomService roomService;

    // GET: Fetch all rooms
    @GetMapping
    public List<RoomDTO> getAllRooms() {
        return roomService.getAllRooms();
    }

    // GET: Fetch a room by ID
    @GetMapping("/{id}")
    public Optional<RoomDTO> getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    // POST: Create a new room
    @PostMapping
    public RoomDTO createRoom(@RequestBody Room room) {
        return roomService.createRoom(room);
    }

    // PUT: Update an existing room
    @PutMapping("/{id}")
    public RoomDTO updateRoom(@PathVariable Long id, @RequestBody Room updatedRoom) {
        return roomService.updateRoom(id, updatedRoom);
    }

    // DELETE: Delete a user by ID
    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomRepository.deleteById(id);
    }
}