# Internationalize

## Configuration

- LocaleResolver
  -- Default Locale - locale.US

- ResourceBundleMessageSource

## Usage

- Autowire MessageSource
- @RequestHeader(value="Accept-Language",required=false) Locale locale
- messageSource.getMessage("helloWorld.message",null, locale)
