//package com.contrader.redman.controller.networkManager;
//
//import com.contrader.redman.model.Task;
//import com.contrader.redman.service.TaskService;
//import com.contrader.redman.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//@RequestMapping("/networkManager")
//public class TasksManagementNMController {
//    private TaskService taskService;
//    private UserService userService;
//
//    @Autowired
//    public TasksManagementNMController(TaskService taskService,UserService userservice) {
//        this.taskService = taskService;
//        this.userService = userService;
//    }
//
//    @RequestMapping("/listaTasks")
//    public String GetListaTasks(Model model){
//        List<Task> listaTasks = new ArrayList<>();
//
//        for (Task task : taskService.findAll()) {
////            String idresp=nodo.getIdresponsabile();
//            String iduser=task.getIdutente();
//            Task newTask= (Task) task.clone();
//
////            if(idresp != null) {
////                //Integer idresp = Integer.parseInt(nodostring);
////                String resp = userService.findByIdutente(Integer.parseInt(idresp));
////                newNodo.setIdresponsabile(resp);
////            }
//
//            if(iduser != null){
//                String user = userService.findByIdutente(Integer.parseInt(iduser));
//                newTask.setIdutente(user);
//            }
//
//            listaTasks.add(newTask);
//        }
//        model.addAttribute("tasks", listaTasks);
//        model.addAttribute("nodo", new Task());
//        model.addAttribute("mode", "listaTasks");
//        return "/networkManager/MenùAdmin";
//    }
//    
//}
