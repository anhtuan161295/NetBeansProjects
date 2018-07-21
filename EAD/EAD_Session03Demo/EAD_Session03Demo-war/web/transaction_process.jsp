<%@page import="test.BankRemote"%>
<%
    BankRemote remote = (BankRemote) session.getAttribute("remote");
    String operation = request.getParameter("operation");
    String amount = request.getParameter("amount");

    if (operation != null) {
        if (operation.equals("deposit")) {
            remote.deposit(Integer.parseInt(amount));
            out.print("Amount successfully deposited!");
        } else {
            if (operation.equals("withdraw")) {
                boolean status = remote.withdraw(Integer.parseInt(amount));
                if (status) {
                    out.print("Amount successfully withdrawn!");
                } else {
                    out.println("Enter less amount");
                }
            } else {
                out.println("Current amount: " + remote.getBalance());
            }
        }
    }
%>
<hr/>
<jsp:include page="transaction.jsp"></jsp:include>