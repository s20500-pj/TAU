from selenium import webdriver
from selenium.common import NoSuchElementException
import logging

from selenium.webdriver.common.by import By

logger = logging.getLogger('wikipedia_test')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)
"""
Należy podać ścieżkę do drivera
Kilkukrotne odpalenie testu nie jest możliwe gdyż wikipedia wprowadzi blokadę captcha
"""
driver = webdriver.Firefox(executable_path=r"D:\programowanie\INNE\geckodriver.exe")
logger.info('Przechodzę na stronę wikipedia.pl')
driver.get('https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna')
logger.info('Klikam zaloguj się')
driver.find_element(By.XPATH, "/html/body/div[4]/div[1]/nav/div/ul/li[5]/a").click()
logger.info('Klikam zaloguj się')
driver.find_element(By.XPATH, "/html/body/div[4]/div[1]/nav/div/ul/li[5]/a").click()
logger.info('Wprowadzam dane użytkownika')
driver.find_element(By.ID, "wpName1").send_keys("testowe")
driver.find_element(By.ID, "wpPassword1").send_keys("password")
logger.info('Klikam zaloguj się')
driver.find_element(By.XPATH, "/html/body/div[3]/div[3]/div[4]/div[1]/div[3]/form/div/div[4]/div/button").click()
try:
    message = driver.find_element(By.XPATH, "/html/body/div[3]/div[3]/div[4]/div[1]/div[3]/form/div[1]")
    desired_message = "Podany login lub hasło są nieprawidłowe. Spróbuj jeszcze raz."
    logger.info(message.text)
    if (desired_message == message.text):
        logger.info("test succeded")
except NoSuchElementException:
    logger.error("Test failed.")
driver.close()
