      function load(pid){
                              	 $.ajax({
                                       url: "AddToCartController",
                                       type: "get", //send it through get method
                                       data: {
                                           Pid: pid
                                       },
                                       success: function (responseData) {
                                         
                                       }
                                   });
                              }  
                              
function pagination( num ){
	 $.ajax({
                                       url: "Loadpagination",
                                       type: "get", //send it through get method
                                       data: {
                                           PageNum: num
                                       },
                                       success: function (responseData) {
                                         
                                       }
                                   });
}
/*  <script language="javascript" type="text/javascript">
        function call(){
            var name = "xyz";
            window.location.replace("Homepage?name="+name);
        }
    </script>
    <input type="button" class="btn btn-outline-dark" value="Get" onclick='call()'>
    <%
        String name=request.getParameter("name");
	System.out.println("nguuuuuuuuuuuuuuuungoai");
        if(name!=null){
        	System.out.println("nguuuuuuuuuuuuuuuu");
            System.out.println(name);
        }
    %>*/