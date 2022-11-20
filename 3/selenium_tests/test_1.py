from selenium import webdriver
from selenium.common import NoSuchElementException
import logging

from selenium.webdriver.common.by import By

logger = logging.getLogger('przypinki_test')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)
"""
Należy podać ścieżkę do drivera
"""
driver = webdriver.Chrome(executable_path=r"D:\programowanie\INNE\chromedriver.exe")
logger.info('Przechodzę na stronę przypinki.pl')
driver.get('https://przypinki.pl/')
cookies = driver.find_element(By.ID, "accept-cookies-checkbox")
logger.info('Akceptuję ciasteczka')
cookies.click()
logger.info('Klikam w kategorie Studniówka')
driver.find_element(By.XPATH, "/html/body/div/aside/nav/ul/li[1]/a").click()
logger.info('Przechodzę na drugą stronę')
driver.find_element(By.XPATH, "/html/body/div/div/div[1]/div[2]/a[1]").click()
logger.info('Klikam na pierwszą przypinkę')
driver.find_element(By.XPATH, "/html/body/div/div/div[2]/a[1]").click()
logger.info('Dodaje do koszyka 1 sztukę')
driver.find_element(By.ID, "buttonDoKoszyka").click()

try:
    logger.info('Sprawdzam czy w koszyku jest 1 sztuka')
    driver.find_element(By.ID, "koszykNaglowek")
except NoSuchElementException:
    logger.error("Test failed.")
driver.close()
