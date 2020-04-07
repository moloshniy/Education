package com.example.education.doc

/**
 *   fabric method -  https://ru.wikipedia.org/wiki/%D0%A4%D0%B0%D0%B1%D1%80%D0%B8%D1%87%D0%BD%D1%8B%D0%B9_%D0%BC%D0%B5%D1%82%D0%BE%D0%B4_(%D1%88%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F)
 *Цель
Определяет интерфейс для создания объекта, но оставляет подклассам решение о том, какой класс инстанцировать.
Фабричный метод позволяет классу делегировать создание подклассов. Используется, когда:

классу заранее неизвестно, объекты каких подклассов ему нужно создавать.
класс спроектирован так, чтобы объекты, которые он создаёт, специфицировались подклассами.
класс делегирует свои обязанности одному из нескольких вспомогательных подклассов, и планируется локализовать
знание о том, какой класс принимает эти обязанности на себя
 *
 *
 */
