package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Task;

public class TaskValidator {
	//バリデーションの実行(エラーが出たら入れていく)
    public static List<String> validate(Task t) {
        List<String> errors = new ArrayList<String>();


        String content_error = validateContent(t.getContent());
        if(!content_error.equals("")) {
            errors.add(content_error);
        }

        return errors;
    }


    // メッセージの必須入力チェック
    private static String validateContent(String content) {
        if(content == null || content.equals("")) {
            return "項目を入力してください。";
        }

        return "";
    }
}
