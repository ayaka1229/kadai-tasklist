package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ここでつながってデータベースにアクセスできるようになってる
		EntityManager em = DBUtil.createEntityManager();

		//アクセスしたデータベースにTaskで作ったJPQLによって全データの問い合わせ可能
		//最後のメソッドで得た結果をリスト形式にして取得。
		List<Task> tasks = em.createNamedQuery("getAllTasks",Task.class).getResultList();

		response.getWriter().append(Integer.valueOf(tasks.size()).toString());

		em.close();

		//ビューにつなげる
		request.setAttribute("tasks",tasks);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/index.jsp");
		rd.forward(request, response);
	}

}
