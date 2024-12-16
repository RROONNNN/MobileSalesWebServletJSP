           function addToCart(pid){
                                	 $.ajax({
                                         url: "AddToCartController",
                                         type: "get", //send it through get method
                                         data: {
                                             Pid: pid
                                         },
                                         success: function (responseData) {
                                        	 
                                        	 changeCartNum();
                                         }
                                     });
                                }  
                               function changeCartNum(){
                              	 $.ajax({
                                       url: "changeCartNum",
                                       type: "get", //send it through get method
                                    
                                       success: function (responseData) {
                                  
                                      	 document.getElementById("buttonchangenum").innerHTML = responseData;                                   	 
                                       }
                                   });
                              }  
                              
                     
							             function LoadmoreFunction(){
                      $.ajax({
                               url: "LoadmoreController",
                               type: "get", //send it through get method
                               data: {
                            	    beginnum:document.getElementsByClassName("productitem").length,
                                  searchbox: document.getElementById("searchbox").value,
                                  radioValue: getSelectedRadioValue("filterprice"),
                                  minprice:document.getElementById("filterpricemin").value,
                                  maxprice:document.getElementById("filterpricemax").value,
                                  id_category:document.getElementById("dsDanhMuc").value,

                               },
                               success: function (responseData) {
                              	 document.getElementById("containerProduct").innerHTML+=responseData
                                 const cartButton = document.querySelectorAll(".cart__button");
                                 cartButton.forEach((button) => {
                                   button.addEventListener("click", cartClick);
                                 });
                              	 
                               }
                           });
                     }