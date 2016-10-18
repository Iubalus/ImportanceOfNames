/**
 * Created by Jubal Rife on 10/17/2016.
 */
public class _0 {

    private String _0;
    private String _1;

    public _0 _0(String _0) {
        this._0 = _0;
        return this;
    }

    public _0 _1(String _0) {
        this._1 = _0;
        return this;
    }

    public int _2() {
        if (_0 == null || _1 == null) {
            throw new _2();
        }
        if (_0.length() != _1.length()) {
            throw new _1();
        }
        if (_1.isEmpty()) {
            return 100;
        } else if (_0.isEmpty()) {
            return 0;
        }
        String[] _2 = _0.split(";");
        String[] _3 = _1.split(";");
        double _4 = 0;
        for (int _5 = 0; _5 < _3.length; _5++) {
            if (!_2[_5].equals(_3[_5])) {
                _4++;
            }
        }
        double _5 = _3.length;
        return (int) (100.0 - ((_4 / _5) * 100.0));
    }


    public static class _1 extends RuntimeException {

    }

    public static class _2 extends RuntimeException {

    }
}
