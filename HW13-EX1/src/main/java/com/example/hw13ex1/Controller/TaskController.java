package com.example.hw13ex1.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")

public class TaskController {

    ArrayList<Task> tasks = new ArrayList<>();

    //read
    @GetMapping("/get")
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @PostMapping("/add")
//create-post
    public String addTask(@RequestBody Task task) {
        tasks.add(task);
        return "task added";
    }

    //update-put
    @PutMapping("\"/update/{index}\"")
    public String updateTask(@PathVariable int index, @RequestBody Task task) {
        tasks.set(index, task);
        return "task updated";
    }

    //    Delete
    @DeleteMapping("/delete/{index}")
    public String deleteTask(@PathVariable int index) {
        tasks.remove(index);
        return "task deleted";
    }

    //Change
@PutMapping("/change/{index}")
    public String changeTask( @PathVariable int index) {
        tasks.get(index);
        Task task1=tasks.get(index);
        task1.setStatus("done");
        tasks.set(index,task1);
        return "task updated";
    }
@GetMapping("/search")
    public String searchTaskByTitle(@PathVariable String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                System.out.println(title);
            }

        }
        return "Tasks Searched";
    }

}





