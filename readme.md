# 🌟 BankReporter

**BankReporter** — это простой и удобный инструмент на **Java**, который умеет анализировать банковские данные из файлов **CSV** и **JSON**.

Это мой **первый проект на Java**, созданный в процессе обучения. Он помогает практиковаться в работе с файлами, парсинге данных и базовой обработке информации.

---

## 📌 Возможности

✨ **Что умеет BankReporter:**

- 📄 Чтение данных из файлов **CSV**
- 🔗 Чтение данных из файлов **JSON**
- 📊 Консольная обработка и вывод информации
- 🛠 Код легко расширяемый для новых форматов и функций

---

## 🛠 Технологии

| Технология | Описание | Эмодзи |
|---------|----------|--------|
| Java 24 | Основной язык проекта | ☕ |
| Gradle | Сборка и управление зависимостями | 📦 |
| Jackson | Парсинг JSON | 🔗 |

---

## 💻 Как использовать

1. **Склонируйте репозиторий:**
   ```bash
   git clone https://github.com/keitah/BankReporter
   ```
2. **Перейдите в каталог проекта:**
   ```bash
   cd BankReporter
   ```
3. **Скомпилируйте и запустите приложение:**
   ```bash
   javac Main.java
   java Main
   ```
4. **Следуйте инструкциям в консоли, чтобы загрузить CSV или JSON файл для анализа.**

## 🚀 Примеры работы

**Пример CSV:**
```json
CSV parsed:
Transaction{account='123455', description='TEST_TRANSCATION', amount=11.00}
Transaction{account='123455', description='покупка 1', amount=123.00}
Transaction{account='123455', description='sim', amount=0.04}
```
**Пример JSON:**
```json
JSON parsed:
Transaction{account='123455', description='TEST_TRANSCATION', amount=11.00}
Transaction{account='123455', description='покупка 1', amount=123.00}
Transaction{account='123455', description='sim', amount=0.04}
```
**Консольный вывод:**
```yaml
> Task :me.keita.reporter.Main.main()
CSV parsed:
   Transaction{account='123455', description='TEST_TRANSCATION', amount=11.00}
   Transaction{account='123455', description='покупка 1', amount=123.00}
   Transaction{account='123455', description='sim', amount=0.04}
JSON parsed:
   Transaction{account='123455', description='TEST_TRANSCATION', amount=11.00}
   Transaction{account='123455', description='покупка 1', amount=123.00}
   Transaction{account='123455', description='sim', amount=0.04} 
```
## 📈 Планы на будущее

- 📊 Поддержка Excel (.xlsx)
- 🔍 Расширенный анализ: суммирование, группировка по категориям
- 🖥 Графический интерфейс (GUI)
- ⚡ Оптимизация и обработка больших файлов

## 📖 Контакты и обратная связь
**Если у вас есть идеи, предложения или замечания, создавайте issues или делайте pull request.**

**Я только учусь, поэтому буду рад любой обратной связи! 😊**