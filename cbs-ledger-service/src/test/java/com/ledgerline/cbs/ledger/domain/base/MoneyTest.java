package com.ledgerline.cbs.ledger.domain.base;

import com.ledgerline.cbs.testing.architecture.bases.BaseUnitTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest implements BaseUnitTest {

    @Test
    void of_shouldNormaliseScaleToCurrencyPrecision_whenAmountHasFewerFractionDigits () {
        // when
        Money usd = Money.of(new BigDecimal("10"), Currency.USD);
        Money iqd = Money.of(new BigDecimal("10.5"), Currency.IQD);

        // then
        assertThat(usd.getAmount()).isEqualTo(new BigDecimal("10.00"));
        assertThat(iqd.getAmount()).isEqualTo(new BigDecimal("10.500"));
    }

    @Test
    void of_shouldAcceptAmount_whenExtraFractionDigitsAreTrailingZeros () {
        // when
        Money money = Money.of(new BigDecimal("1.2300"), Currency.USD);

        // then
        assertThat(money.getAmount()).isEqualTo(new BigDecimal("1.23"));
    }

    @Test
    void of_shouldThrowInvalidMoneyException_whenAmountExceedsCurrencyPrecision () {
        // when / then
        assertThatThrownBy(() -> Money.of(new BigDecimal("1.234"), Currency.USD))
            .isInstanceOf(InvalidMoneyException.class)
            .hasMessageContaining("2 fraction digits");
    }

    @Test
    void of_shouldThrowNullPointerException_whenAmountOrCurrencyIsNull () {
        // when / then
        assertThatThrownBy(() -> Money.of(null, Currency.USD))
            .isInstanceOf(NullPointerException.class);
        assertThatThrownBy(() -> Money.of(BigDecimal.ONE, null))
            .isInstanceOf(NullPointerException.class);
    }

    @Test
    void add_shouldReturnSum_whenCurrenciesMatch () {
        // given
        Money a = Money.of(new BigDecimal("10.25"), Currency.EUR);
        Money b = Money.of(new BigDecimal("5.75"), Currency.EUR);

        // when
        Money sum = a.add(b);

        // then
        assertThat(sum).isEqualTo(Money.of(new BigDecimal("16.00"), Currency.EUR));
    }

    @Test
    void add_shouldThrowCurrencyMismatchException_whenCurrenciesDiffer () {
        // given
        Money usd = Money.of(BigDecimal.ONE, Currency.USD);
        Money eur = Money.of(BigDecimal.ONE, Currency.EUR);

        // when / then
        assertThatThrownBy(() -> usd.add(eur))
            .isInstanceOf(CurrencyMismatchException.class)
            .hasMessageContaining("USD")
            .hasMessageContaining("EUR");
    }

    @Test
    void subtract_shouldAllowNegativeResult_whenSubtractingLargerAmount () {
        // given
        Money balance = Money.of(new BigDecimal("5.00"), Currency.GBP);
        Money debit = Money.of(new BigDecimal("7.50"), Currency.GBP);

        // when
        Money result = balance.subtract(debit);

        // then
        assertThat(result.getAmount()).isEqualTo(new BigDecimal("-2.50"));
        assertThat(result.isNegative()).isTrue();
    }

    @Test
    void subtract_shouldThrowCurrencyMismatchException_whenCurrenciesDiffer () {
        // given
        Money aed = Money.of(BigDecimal.TEN, Currency.AED);
        Money gbp = Money.of(BigDecimal.ONE, Currency.GBP);

        // when / then
        assertThatThrownBy(() -> aed.subtract(gbp))
            .isInstanceOf(CurrencyMismatchException.class);
    }

    @Test
    void zero_shouldBeNeitherPositiveNorNegative_whenCreated () {
        // when
        Money zero = Money.zero(Currency.USD);

        // then
        assertThat(zero.isZero()).isTrue();
        assertThat(zero.isPositive()).isFalse();
        assertThat(zero.isNegative()).isFalse();
    }

    @Test
    void isGreaterThanOrEqual_shouldCompareByValue_whenScalesDiffer () {
        // given
        Money a = Money.of(new BigDecimal("10.00"), Currency.USD);
        Money b = Money.of(new BigDecimal("10"), Currency.USD);
        Money c = Money.of(new BigDecimal("10.01"), Currency.USD);

        // then
        assertThat(a.isGreaterThanOrEqual(b)).isTrue();
        assertThat(a.isLessThan(c)).isTrue();
        assertThat(c.isLessThan(a)).isFalse();
    }

    @Test
    void isLessThan_shouldThrowCurrencyMismatchException_whenCurrenciesDiffer () {
        // given
        Money usd = Money.of(BigDecimal.ONE, Currency.USD);
        Money eur = Money.of(BigDecimal.ONE, Currency.EUR);

        // when / then
        assertThatThrownBy(() -> usd.isLessThan(eur))
            .isInstanceOf(CurrencyMismatchException.class);
    }
}
