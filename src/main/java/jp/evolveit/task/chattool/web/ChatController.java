package jp.evolveit.task.chattool.web;

import jp.evolveit.task.chattool.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ChatController {
    private static Logger logger = LoggerFactory.getLogger(ChatController.class);

    @Autowired
    ChatService chatService;

    @ModelAttribute
    ChatForm setUpForm() {
        return new ChatForm();
    }

    @GetMapping("/")
    String index(Model model) {
        var chats = chatService.findAll();
        model.addAttribute("chats", chats);
        return "index";
    }

    @PostMapping("/chat/add")
    String addComment(@Validated ChatForm form, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        // validate error
        if (result.hasErrors()) {
            var chats = chatService.findAll();
            model.addAttribute("chats", chats);
            return "index";
        }

        // 更新
        try {
            chatService.addMessage(form.getUsername(), form.getMessage());
        } catch (Exception e) {
            logger.warn("コメント追加に失敗。", e);
            redirectAttributes.addFlashAttribute("flash", "コメントを追加できませんでした。");
        }
        return   "redirect:/";
    }
}
