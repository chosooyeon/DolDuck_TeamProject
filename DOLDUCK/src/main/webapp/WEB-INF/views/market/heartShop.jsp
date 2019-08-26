<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All About K-POP! - Shop</title>
</head>
<body>
<%@include file="../header.jsp" %>

   <div class="container market">
   
      
      <h1> Market </h1>
      <ul class="nav nav-tabs market_ul">
         <li class="nav-item">
            <a class="nav-link market_link" href="heartShop.do">HeartShop</a>
         </li>
         <li class="nav-item">
            <a class="nav-link market_link" href="market_list.do">Goodies</a>
         </li>

      </ul>
      <div class="col-lg-12 market_border">
         <div class="heartShop">
            <div class="heartShop-item-title"><span>하트존</span></div>
            <ul class="">
               <li class="heartShop-item">
                  <div class="vote-area-img"><img class="heart_size"src="resources/images/heart.png"></div>
                  <div class="vote-area-subject">하트 10개</div>
                  <div class="vote-area-button">
                     <span class="btn btn-buy-item">1,000원
                        <input type="hidden" name="kindof" value="heart">
                        <input type="hidden" name="item-amount" value="10">
                        <input type="hidden" name="item-price" value="1000">
                     </span>
                  </div>
               </li>
               <li class="heartShop-item">
                  <div class="vote-area-img"><img class="heart_size"src="resources/images/heart.png"></div>
                  <div class="vote-area-subject">하트 20+1개</div>
                  <div class="vote-area-button">
                     <span class="btn btn-buy-item">2,000원
                        <input type="hidden" name="kindof" value="heart">
                        <input type="hidden" name="item-amount" value="21">
                        <input type="hidden" name="item-price" value="2000">
                     </span>
                  </div>
               </li>
               <li class="heartShop-item">
                  <div class="vote-area-img"><img class="heart_size"src="resources/images/heart.png"></div>
                  <div class="vote-area-subject">하트 50+5개</div>
                  <div class="vote-area-button">
                     <span class="btn btn-buy-item">5,000원
                        <input type="hidden" name="kindof" value="heart">
                        <input type="hidden" name="item-amount" value="55">
                        <input type="hidden" name="item-price" value="5000">
                     </span>
                  </div>
               </li>
               <li class="heartShop-item">
                  <div class="vote-area-img"><img class="heart_size"src="resources/images/heart.png"></div>
                  <div class="vote-area-subject">하트 100+20개</div>
                  <div class="vote-area-button">
                     <span class="btn btn-buy-item" >10,000원
                        <input type="hidden" name="kindof" value="heart">
                        <input type="hidden" name="item-amount" value="120">
                        <input type="hidden" name="item-price" value="10000">
                     </span>
                  </div>
               </li>
            </ul>
            <div class="heartShop-item-title"><span>투표권</span></div>
            <ul>
               <li class="heartShop-item">
                  <div class="vote-area-img"><img src="https://www.bestidol.co.kr/assets/image/icon/store/store-item-vote.png"></div>
                  <div class="vote-area-subject">투표권 1개</div>
                  <div class="vote-area-button">
                     <span class="btn btn-buy-item"><i class="fas fa-heart"></i>&nbsp;5
                        <input type="hidden" name="kindof" value="vote">
                        <input type="hidden" name="item-amount" value="1">
                        <input type="hidden" name="item-price" value="5">
                     </span>
                  </div>
               </li>
               <li class="heartShop-item">
                  <div class="vote-area-img"><img src="https://www.bestidol.co.kr/assets/image/icon/store/store-item-vote.png"></div>
                  <div class="vote-area-subject">투표권 11개</div>
                  <div class="vote-area-button">
                     <span class="btn btn-buy-item"><i class="fas fa-heart"></i>&nbsp;50
                        <input type="hidden" name="kindof" value="vote">
                        <input type="hidden" name="item-amount" value="11">
                        <input type="hidden" name="item-price" value="50">
                     </span>
                  </div>
               </li>
               <li class="heartShop-item">
                  <div class="vote-area-img"><img src="https://www.bestidol.co.kr/assets/image/icon/store/store-item-vote.png"></div>
                  <div class="vote-area-subject">투표권 55개</div>
                  <div class="vote-area-button">
                     <span class="btn btn-buy-item"><i class="fas fa-heart"></i>&nbsp;250
                        <input type="hidden" name="kindof" value="vote">
                        <input type="hidden" name="item-amount" value="55">
                        <input type="hidden" name="item-price" value="250">
                     </span>
                  </div>
               </li>
               <li class="heartShop-item">
                  <div class="vote-area-img"><img src="https://www.bestidol.co.kr/assets/image/icon/store/store-item-vote.png"></div>
                  <div class="vote-area-subject">투표권 120개</div>
                  <div class="vote-area-button">
                     <span class="btn btn-buy-item"><i class="fas fa-heart"></i>&nbsp;500
                        <input type="hidden" name="kindof" value="vote">
                        <input type="hidden" name="item-amount" value="120">
                        <input type="hidden" name="item-price" value="500">
                     </span>
                  </div>
               </li>
            </ul>
         </div>   
      </div>
      
      <!-- Modal -->
      <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h3 class="modal-title" id="exampleModalCenterTitle">결제하기</h3>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
                  <span>선택하신제품 제품</span>
                  <h3><span id="selected-item"></span><b id="total-amount"></b>ea</h3><br>
               <h2 id="total-price"></h2>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">취&nbsp;&nbsp;소</button>
              <button type="button" class="btn btn-primary btn-purchase">결&nbsp;&nbsp;제</button>
            </div>
          </div>
        </div>
      </div>
      
      
      <script src="" type="text/javascript"></script>
      <script src="resources/js/utils/shop.js" type="text/javascript"></script>   
      <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
   </div>
<%@include file="../footer.jsp" %>
</body>
</html>