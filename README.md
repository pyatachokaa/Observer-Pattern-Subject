# Observer-Pattern-Subject
The Stock class is the subject, keeping track of its investors.
The Investor class is the observer, reacting to changes in stock prices.
When a stock's price changes, it notifies all its investors.
Subject (Stock):
Keeps a list of investors.
Notifies investors when its price changes.
Observer (Investor):
Registers interest in stocks.
Reacts to changes in stock prices.
