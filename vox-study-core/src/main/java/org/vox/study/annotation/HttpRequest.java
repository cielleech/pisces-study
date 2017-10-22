package org.vox.study.annotation;

public class HttpRequest extends GeneralRequest {
	@HttpParam(value = "product_id")
	private String productId;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public static void main(String[] args) {
		HttpRequest request = new HttpRequest();
		request.setProductId("1234");

		System.out.println(HttpClient.execute(request));
	}
}