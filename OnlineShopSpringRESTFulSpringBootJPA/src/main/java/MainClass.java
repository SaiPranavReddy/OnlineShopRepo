public class MainClass {
/*	public  static  void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		

		//getProductAllJSON();
		//getProductAllXML();
		//getProductRequestParam();
		//addProductPost();
		//addProductPostUsingBasicAuth();
		//addBulkProductsDataJSON();
		//getProductAllJSON();
	}*/
	/*public static void consumeRESTServicesJSON(){
		String restURL="http://localhost:8080/RESTWebServicesAllmethods/"
				+ "onlineshop/productCatlog/allproductsjson";
		try {
			URL url = new URL(restURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if(conn.getResponseCode()!=200) throw new RuntimeException("some things went wrong");
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String data="";
			while((data=reader.readLine())!=null){
				List<Product> productList = new ObjectMapper().readValue
						(data,new TypeReference<List<Product>>(){});
				for (Product product : productList) {
					System.out.println(product);
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public static void getProductAllJSON() throws JsonParseException, JsonMappingException, IOException{
		final String uri = "http://localhost:8080/RESTWebServicesUsingSpringRESTALLMethods/onlineShop/productCatlog/allProductsJson";
		RestTemplate restTemplate = new RestTemplate();
		String jsonData = restTemplate.getForObject(uri, String.class);
		List<Product> productList = new ObjectMapper().readValue(jsonData,new TypeReference<List<Product>>(){});
		for (Product product : productList) {
			System.out.println(product);
		}
	}
	public static void getProductAllXML(){
		final String uri = "http://localhost:8080/RESTWebServicesUsingSpringRESTALLMethods/onlineShop"
				+ "/productCatlog/allProductsXml";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		System.out.println(result);
	}
	public static void getProductRequestParam(){
		try {
			final String uri = "http://localhost:8080/RESTWebServicesUsingSpringRESTALLMethods"
					+ "/onlineShop/productCatlog/getProductQueryParam?productCode=1113434";
			RestTemplate restTemplate = new RestTemplate();
		//	restTemplate.setErrorHandler(new CustomResponseErrorHandler());
			Product Product = restTemplate.getForObject(uri, Product.class);
			System.out.println(Product);
		} catch (RestClientException e) {
			System.out.println(e.getCause().getMessage());
		}
	}
	public static void getProductPathParam(){
		try {
			final String uri = "http://localhost:8080/RESTWebServicesUsingSpringRESTALLMethods/onlineShop"
					+ "/productCatlog/getProductPathParam/111";
			RestTemplate restTemplate = new RestTemplate();
			//restTemplate.setErrorHandler(new CustomResponseErrorHandler());
			Product Product = restTemplate.getForObject(uri, Product.class);
			System.out.println(Product);
		} catch (RestClientException e) {
			System.out.println(e.getCause().getMessage());
		}
	}
	public static void addBulkProductsDataJSON() throws JsonProcessingException {
		final String url ="http://localhost:8080/RESTWebServicesUsingSpringRESTALLMethods"
				+ "/onlineShop/productCatlog/addBulkProductsJSON";
		ArrayList<Product> products = new ArrayList<>();
		products.add(new Product(83427,1882, "Marker", "GJkbbkb"));
		products.add(new Product(26287788, 1882,"Duster", "GJkbbkb"));
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(products);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<>(json,headers);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(url, httpEntity);
		
	}
	public static void addProductPost(){
		final String url ="http://localhost:8080/RESTWebServicesUsingSpringRESTALLMethods"
				+ "/onlineShop/productCatlog/addProductPOST";
		Product product = new Product(9999,2000, "T.V remote", "T.V remote control" );
		MultiValueMap< String, Object> map= new LinkedMultiValueMap<>();
		map.add("productCode", product.getProductCode());
		map.add("productPrice", product.getProductPrice());
		map.add("productName", product.getProductName());
		map.add("productDiscription", product.getProductDiscription());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(map,headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String>responseEntity=restTemplate.postForEntity(url, httpEntity, String.class);
		System.out.println( responseEntity.getStatusCode()+" "+responseEntity.getBody());
	}
	public static void addProductPostUsingBasicAuth(){
		try {
			final String url ="http://localhost:8080/RESTWebServicesUsingSpringRESTALLMethods"
					+ "/onlineShop/productCatlog/addProductPOSTBasicAuth";
			MultiValueMap< String, String> map= new LinkedMultiValueMap<>();
			map.add("productCode", "6633");
			map.add("productPrice", "7000");
			map.add("productName", "ABC");
			map.add("productDiscription", "gigkhilhil");
			String plainCreds = "satish:helloworld23232";
			byte[] plainCredsBytes = plainCreds.getBytes();
			 BASE64Encoder encoder = new BASE64Encoder();
			 String userCredintails = encoder.encode(plainCredsBytes);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Basic " + userCredintails);
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map,headers);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.setErrorHandler(new ResponseErrorHandler() {
				@Override
				public boolean hasError(ClientHttpResponse response) throws IOException {
					boolean hasError = false;
					int rawStatusCode = response.getRawStatusCode();if (rawStatusCode == 417)
						hasError = true;
					return hasError;
				}
				@Override
				public void handleError(ClientHttpResponse response) throws IOException {
					BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody()));
					String errorMessage=null;
					while((errorMessage=reader.readLine())!=null){}
					//throw new UserAuthException(errorMessage);
				}
			});
			ResponseEntity<String>responseEntity=restTemplate.postForEntity(url, httpEntity, String.class);
			System.out.println( responseEntity.getStatusCode()+" "+responseEntity.getBody());
		} catch (RestClientException e) {
			System.out.println(e.getCause().getMessage());
		}
	}*/
}
