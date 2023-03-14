package com.test.executeTest;

import com.test.webpages.AddtoCart;
import com.test.webpages.ValidateProductAndPrice;

public class ExecuteTestcases {

	public static void main(String[] args) {

		ValidateProductAndPrice validateproductandpricesobj = new ValidateProductAndPrice();
		AddtoCart addtocartobj = new AddtoCart();

		addtocartobj.AddtoCartCheck();

	}

}
