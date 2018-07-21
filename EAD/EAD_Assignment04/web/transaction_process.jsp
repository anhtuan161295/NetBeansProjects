<%@page import="dao.AccountDAO"%>
<%@page import="model.Account"%>
<%

    AccountDAO dao = new AccountDAO();
    Account user = (Account) session.getAttribute("user");
    String operation = request.getParameter("operation");
    String amount = request.getParameter("amount");
    int amt = Integer.parseInt(amount);

    if (operation != null) {
        if (operation.equals("deposit")) {
            user.setBalance(user.getBalance() + amt);
            dao.updateUser(user);
            out.print("Amount successfully deposited!");
        } else {
            if (operation.equals("withdraw")) {
                if (user.getBalance() >= amt) {
                    user.setBalance(user.getBalance() - amt);
                    dao.updateUser(user);
                    out.print("Amount successfully withdrawn!");
                } else {
                    out.println("Enter less amount");
                }

            } else {
                out.println("Current amount: " + user.getBalance());
            }
        }
    }
%>
<hr/>
<jsp:include page="transaction.jsp"></jsp:include>