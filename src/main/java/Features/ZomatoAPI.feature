Feature: zomato get api

Scenario: To validate location in zomato api
	Given I do a get call to zomato and search location 'hyderabad'
	Given I do a get call to zomato and search location 'bengaluru'
	

	