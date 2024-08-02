# i2ihwkafka
# Kafka demo homework for i2i systems internship

Kafka ile Veri İşleme Projesi
Bu proje, Apache Kafka kullanarak veri üretimi ve tüketimini gerçekleştirmeyi amaçlamaktadır. Proje, bir yayımlayıcı (producer) ve bir tüketici (consumer) uygulaması içerir. İşte projenin temel özellikleri:

## Veri Yayınlama (Publisher):
Bir Java uygulaması, Kafka'ya veri gönderir.
Gönderilen veri, iki değişken içeren bir sınıftan oluşur: operand ve operation.
Örneğin, operand olarak 13 ve operation olarak fibPrime değeri gönderilir.

## Veri Tüketme (Consumer):
Başka bir Java uygulaması, Kafka'dan veri alır ve işler.
Tüketici, gelen operand değeri için operation değerine göre belirli işlemleri gerçekleştirir:
Eğer operation değeri fibPrime ise, operand'ın hem Fibonacci sayısı hem de asal sayı olup olmadığını kontrol eder.
Operasyon değeri geçersizse veya null ise, bir hata mesajı gönderir.

## Kafdrop ile Yönetim:
Proje ayrıca Docker üzerinde çalışan Kafdrop uygulamasını içerir.
Kafdrop, Kafka'nın yönetim ve izleme panelini sağlar.
Kafka'nın mevcut konuları, mesajları ve diğer bilgileri hakkında görsel bir arayüz sunar.
Bu proje, veri işleme ve dağıtımının temel prensiplerini anlamak için mükemmel bir örnek sağlar. Kafka'nın veri akışını nasıl yönettiğini, veriyi nasıl yayınladığını ve tükettiğini öğrenmenizi sağlar. Ayrıca, Kafdrop kullanarak Kafka'nın iç işleyişini ve veri akışını görsel olarak izleyebilirsiniz.
