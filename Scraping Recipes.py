# importing necessary libraries
import urllib.request
from bs4 import BeautifulSoup
from urllib.request import Request, urlopen
import requests
import pandas as pd

"""
A class for Recipe structure.
Methods:
1. Function to consolidate a recipe object to a recipe text file
2. Function to write the recipe text to a file.
"""
class Recipe:  
    def __init__(self, title, author, ingredients, directions):
        self.title = title
        self.author = author
        self.ingredients = ingredients
        self.directions = directions
        self.recipe_file = ""
        
    def consolidate_to_file(self):
        self.recipe_file += self.title + "\n"
        self.recipe_file += "Recipe by : " + self.author + "\n"
        self.recipe_file += "Ingredients : "
        for ingredient in self.ingredients:
            self.recipe_file += ingredient
        self.recipe_file += "\n"
        self.recipe_file += "Directions : " + self.directions
    
    def write_to_file(self):
        filename = "/recipes/"+ self.title + ".txt"
        file = open(filename,"w")
        file.write(self.recipe_file)

"""
A Function to obtain links to all the recipes listed in the seed URL.
"""
def get_data():
    page = "https://www.allrecipes.com/?page="
    all_recipes = []
    page_number = 1
    while page_number <= 5:
        all_recipes.extend(get_data_for_page(page + str(page_number)))
        page_number += 1
    return all_recipes

"""
A Function to find the link to recipes given a page
"""
def get_data_for_page(page):
    response = requests.get(page ,headers={'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36'})
    soup = BeautifulSoup(response.content,"html.parser")
    contents = soup.findAll('article', {'class' : 'fixed-recipe-card'})
    recipes_links = []
    for content in contents:
        recipe_info = content.find('div', {'class' : 'fixed-recipe-card__info'})
        link = recipe_info.find('a', href = True)['href']
        recipes_links.append(link)
    return recipes_links

"""
A Function to get recipe contents given a recipe link and write to Recipe object
"""
def parse_recipes_and_write_to_file(all_recipes):
    recipe_objects = []
    for recipe in all_recipes:
        response = requests.get(recipe ,headers={'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36'})
        soup = BeautifulSoup(response.content,"html.parser")

        title = soup.find('h1', {'class' : 'recipe-summary__h1'})
        if title is not None:
            title = title.text
        else:
            title = ""

        author = soup.find('span', {'class' : 'submitter__name'})
        if author is not None:
            author = author.text
        else:
            author = ""

        ingredients = soup.findAll('span', {'class' : 'recipe-ingred_txt added'})
        if ingredients is not None:
            ingredients = [x.text for x in ingredients]
        else:
            ingredients = []

        directions_list = soup.findAll('span', {'class' : 'recipe-directions__list--item'})
        directions = ""
        for direction in directions_list:
            directions += direction.text

        recipe_objects.append(Recipe(title, author, ingredients, directions))
        
        for recipe in recipe_objects:
            recipe.consolidate_to_file()
            recipe.write_to_file()

# Calls to appropriate functions to crawl and obtain recipes
all_recipes = get_data()
parse_recipes_and_write_to_file(all_recipes)